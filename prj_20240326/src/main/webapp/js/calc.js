let input = '0';
let num1 = 0;
let num2 = 0;
let oper = '';
let result = 0;

document.querySelector("#outputDiv").innerHTML = input;

function input1() {
    if (input === '0') input = '1'
    else input += '1';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input2() {
    if (input === '0') input = '2'
    else input += '2';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input3() {
    if (input === '0') input = '3'
    else input += '3';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input4() {
    if (input === '0') input = '4'
    else input += '4';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input5() {
    if (input === '0') input = '5'
    else input += '5';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input6() {
    if (input === '0') input = '6'
    else input += '6';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input7() {
    if (input === '0') input = '7'
    else input += '7';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input8() {
    if (input === '0') input = '8'
    else input += '8';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input9() {
    if (input === '0') input = '9';
    else input += '9';
    document.querySelector("#outputDiv").innerHTML = input;
}

function input0() {
    if (input !== '0') {
        input += '0';
        document.querySelector("#outputDiv").innerHTML = input;
    }
}

function inputErase() {
    if (input !== '0') {
        input = input.slice(0, -1);
        if (input === '') input = '0';
        document.querySelector("#outputDiv").innerHTML = input;
    }
}

function inputEnter() {
    num2 = input;
    calculate();
    document.querySelector("#outputDiv").innerHTML = result;
}

function plus() {
    if (num1 === 0) {
        num1 = input;
        num2 = 0;
        oper = '+';
    } else {
        num2 = input;
    }
    calculate();
    num1 = result;
    num2 = 0;
    input = '0'
    oper = '+';
    document.querySelector("#outputDiv").innerHTML = result;
}

function minus() {
    if (num1 === 0) {
        num1 = input;
        num2 = 0;
        oper = '+';
    } else {
        num2 = input;
    }
    calculate();
    num1 = result;
    input = '0'
    oper = '-';
    document.querySelector("#outputDiv").innerHTML = result;
}

function multi() {
    if (num1 === 0) {
        num1 = input;
        num2 = 0;
        oper = '+';
    } else {
        num2 = input;
    }
    calculate();
    num1 = result;
    input = '0'
    oper = '*';
    document.querySelector("#outputDiv").innerHTML = result;
}

function division() {
    if (num1 === 0) {
        num1 = input;
        num2 = 0;
        oper = '+';
    } else {
        num2 = input;
    }
    calculate();
    num1 = result;
    input = '0'
    oper = '/';
    document.querySelector("#outputDiv").innerHTML = result;
}

function calculate() {
    if (oper === '+') {
        result = parseFloat(num1) + parseFloat(num2);
    } else if (oper === '-') {
        result = parseFloat(num1) - parseFloat(num2);
    } else if (oper === '*') {
        result = parseFloat(num1) * parseFloat(num2);
    } else if (oper === '/') {
        result = parseFloat(num1) / parseFloat(num2);
    }
}

addEventListener('keydown', (e)=>{
    if(e.key==='1'){
        input1();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='2'){
        input2();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='3'){
        input3();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='4'){
        input4();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='5'){
        input5();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='6'){
        input6();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='7'){
        input7();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='8'){
        input8();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='9'){
        input9();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='0'){
        input0();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='+'){
        plus();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='-'){
        minus();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='*'){
        multi();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='/'){
        division();
    }
})

addEventListener('keydown', (e)=>{
    if(e.key==='Enter'){
        inputEnter();
    }
})