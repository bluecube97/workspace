const openBtn = document.querySelector('.modalOpen');
const closeBtn = document.querySelector('.modalClose');
const modal = document.querySelector('.modalContainer');
let hide = document.querySelector('.hide');

console.log(openBtn);
console.log(closeBtn);
console.log(modal);

openBtn.addEventListener('click', () => {
    console.log(openBtn);
    console.log(closeBtn);
    console.log(modal);

    modal.classList.remove('hide');
});

closeBtn.addEventListener('click', () => {
    modal.classList.add('hide');
});