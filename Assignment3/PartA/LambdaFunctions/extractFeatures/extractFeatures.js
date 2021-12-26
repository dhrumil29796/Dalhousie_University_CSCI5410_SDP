console.log('Loading function');

const aws = require('aws-sdk');

const s3 = new aws.S3({ apiVersion: '2006-03-01' });


exports.handler = async (event, context) => {
    //console.log('Received event:', JSON.stringify(event, null, 2));

    // Get the object from the event and show its content type
    const bucket = event.Records[0].s3.bucket.name;
    const key = decodeURIComponent(event.Records[0].s3.object.key.replace(/\+/g, ' '));
    const params = {
        Bucket: bucket,
        Key: key,
    };
    console.log(params);
    extractFeatures(params);
    try {
        const { ContentType } = await s3.getObject(params).promise();
        console.log('CONTENT TYPE:', ContentType);
        return ContentType;
    } catch (err) {
        console.log(err);
        const message = `Error getting object ${key} from bucket ${bucket}. Make sure they exist and your bucket is in the same region as this function.`;
        console.log(message);
        throw new Error(message);
    }
};

const extractFeatures = (params) => {

    let uploadParams = {
        Bucket: 'tagsb00870600',
        Key: ''
    };

    let wordCount = '{ \n "' + params.Key + 'ne" : [ ';

    s3.getObject(params, function (err, metadata) {
        if (err && err.code === 'Not found') {
            console.log("Object not found");
        } else {
            let filedata = metadata.Body.toString('utf-8');
            filedata = filedata.split("\n");
            for (let i = 0; i < filedata.length; i++) {

                let eachwords = filedata[i].split(' ');
                for (let k = 0; k < eachwords.length; k++) {
                    if (eachwords[k] === '') {
                        continue;
                    }
                    eachwords[k] = eachwords[k].replace(/[^a-zA-Z ]/g, "");
                    if (eachwords[k].charAt(0) === eachwords[k].charAt(0).toUpperCase()) {
                        if (eachwords[k] === '') {
                            continue;
                        }
                        let wordformat = "\n\t{ ";
                        wordformat = wordformat + '"' + eachwords[k] + '" : 1 } ,';
                        wordCount = wordCount + wordformat;
                    }
                }
            }
            wordCount = wordCount.slice(0, -1);
            wordCount = wordCount + " \n]}";
            let filename = params.Key + "ne";
            uploadParams.Key = filename;
            uploadParams.Body = wordCount;
            s3.upload(uploadParams, function (s3Err, data) {
                if (s3Err) {
                    console.log(s3Err);
                }
                console.log(`File uploaded successfully at ${data.Location}`);
            });
            console.log(wordCount);
            let countjsonarray = JSON.parse(wordCount);
        }
    });
};
