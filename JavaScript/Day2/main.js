let prom = new Promise((resolve, reject) => {
    setTimeout(() => {
        let success = true;

        if (success) {
            resolve('Job Success');
        } else {
            reject('Job Failed');
        }
    }, 2000);
});

prom.then((message) => {
    console.log(message);
}).catch((error) => {
    console.log(error);
});
