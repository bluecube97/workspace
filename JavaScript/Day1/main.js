let nums = [];
let ops = [];
let result = '';
let currentNum = '';

function save(num) {
    currentNum += num;
    result += num;

    document.getElementById('console').innerText = result;
}

function saveOp(op) {
    if (currentNum !== '') {
        nums.push(eval(currentNum));
    }

    ops.push(op);

    result += ' ';
    result += op;
    result += ' ';

    currentNum = '';

    document.getElementById('console').innerText = result;
    // document.getElementById('console').innerHTML = `<h1>${nums} ${ops}</h1>`;
}

function calculate() {
    if (currentNum !== '') {
        nums.push(currentNum);
    }

    let expression = '';
    for (let i = 0; i < nums.length; i++) {
        expression += nums[i];
        if (i < ops.length) {
            expression += ops[i];
        }
    }

    try {
        const result = eval(expression);
        document.getElementById('console').innerHTML = `<h1>${result}</h1>`;

        nums = [result.toString()];
        ops = [];
        currentNum = '';
    } catch (e) {
        document.getElementById('console').innerText = 'Error!';
        nums = [];
        ops = [];
        currentNum = '';
    }
}