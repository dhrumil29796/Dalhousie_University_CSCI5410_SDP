var AWS = require('aws-sdk');
var fs = require('fs');

s3 = new AWS.S3({
    profile: "default",
    accessKeyId: "ASIAYN2RGTSOMIPYCFJD",
    secretAccessKey: "mnWwq/1+B/acl/0W39dRs1S2dGHLJYoZQ24+9UPb",
    sessionToken: "FwoGZXIvYXdzELz//////////wEaDHJE4g4W7IhI3mAQjSK9AaCUIMJ9sHrrT7CwmeMycxSeMtGFIaZV4ra3P8j+RfD5H8ncKF9Cu0hlL0QKf6rrjkS1snjIm+FE3hU8E6AsfFpTsBiiieRtIVtmcZh+3oIT0ncUfLNRXW9eaQusTAeokEWgJBaJh0FjFM4NTsKotTAr7zHJ3l8nYYgWIEFchLpx3FTRY+BvHmo9kO4hQQruuRrw2MgMCq280dwCCOuJ9r5B5ZNJv+mNIsPeVZHeCSzcHLaN+0k25jxC9af8WCjYr8WMBjItBS05TjaD5g4JrBLdJBM5eNssaO3GHAt5Qf4GKAxKw/tdWACFeyAigPvErx4a",
    region: "us-east-1"
});

comprehend = new AWS.Comprehend({
    profile: "default",
    accessKeyId: "ASIAYN2RGTSOMIPYCFJD",
    secretAccessKey: "mnWwq/1+B/acl/0W39dRs1S2dGHLJYoZQ24+9UPb",
    sessionToken: "FwoGZXIvYXdzELz//////////wEaDHJE4g4W7IhI3mAQjSK9AaCUIMJ9sHrrT7CwmeMycxSeMtGFIaZV4ra3P8j+RfD5H8ncKF9Cu0hlL0QKf6rrjkS1snjIm+FE3hU8E6AsfFpTsBiiieRtIVtmcZh+3oIT0ncUfLNRXW9eaQusTAeokEWgJBaJh0FjFM4NTsKotTAr7zHJ3l8nYYgWIEFchLpx3FTRY+BvHmo9kO4hQQruuRrw2MgMCq280dwCCOuJ9r5B5ZNJv+mNIsPeVZHeCSzcHLaN+0k25jxC9af8WCjYr8WMBjItBS05TjaD5g4JrBLdJBM5eNssaO3GHAt5Qf4GKAxKw/tdWACFeyAigPvErx4a",
    region: "us-east-1"
});

const params = {
    Bucket: 'twitterdatab00870600',
    Key: 'file_mongo_tweets.txt'
};

file_name = "file_mongo_tweets.txt";

s3.getObject(params, function (err, metadata) {
    if (err && err.code === 'NotFound') {
        console.log(params);
        console.log("ObjectNot found");
    } else {
        console.log(params);
        let filedata = metadata.Body.toString('utf-8');
        const arr = filedata.split("\n");
    console.log(arr);
    for(let i=0;i<arr.length;i++){
        var params = {
            LanguageCode:'en',
            Text: arr[i]
        }
        if(arr[i]==''){
            continue;
        }else{
            sentimentdetector(params);
        }
        }
    }
    
});

function sentimentdetector(params){
    comprehend.detectSentiment(params,function(err,data){
        if(err){
            console.log(err,err.stack);
        }else{
            console.log(data)
        }
    })
}
