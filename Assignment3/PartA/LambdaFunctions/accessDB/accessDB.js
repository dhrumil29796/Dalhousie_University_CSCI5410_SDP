console.log('Loading function');

const aws = require('aws-sdk');

const s3 = new aws.S3({ apiVersion: '2006-03-01' });

var docClient = new aws.DynamoDB.DocumentClient();

const ddb = new aws.DynamoDB({ apiVersion: '2012-08-10 '});


exports.handler = async (event, context) => {
    //console.log('Received event:', JSON.stringify(event, null, 2));

    // Get the object from the event and show its content type
    const bucket = event.Records[0].s3.bucket.name;
    const key = decodeURIComponent(event.Records[0].s3.object.key.replace(/\+/g, ' '));
    const params = {
        Bucket: bucket,
        Key: key,
    };
    let filedata;
    s3.getObject(params, function (err, metadata) {
        if (err && err.code === 'Not found') {
            console.log("Object not found");
        } else {
            filedata = metadata.Body.toString('utf-8');
        }
    })
    accessDB(filedata, params.Key);
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


const accessDB = async (wordsarray, key1) => {

    console.log(wordsarray[key1]);
    for (let a = 0; a < wordsarray[key1].length; a++) {
        for (var key in wordsarray[key1][a]) {
            docClient.put(nameEntityCol, function(err, data) {
    if (err) {
        console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Added item:", JSON.stringify(data, null, 2));
    }
    });
        docClient.put(frequencyCol, function(err, data) {
    if (err) {
        console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Added item:", JSON.stringify(data, null, 2));
    }
    });
        docClient.put(timestampOfEntryCol, new AttributeValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
            .format(new Date())), function(err, data) {
    if (err) {
        console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("Added item:", JSON.stringify(data, null, 2));
    }
    });
    }
}
};

