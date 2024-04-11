let i = 10;
let j = 20;

let sum1 = (one, two) => {
    let l = one + two;
    console.log(l);
    minus1(one, two);
}

function minus1(one, two) {
    let k = one - two;
    console.log(k);
}

sum1(i, j);

console.log(sum1);
console.log(minus1);