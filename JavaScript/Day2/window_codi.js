'use strict';

const special = document.querySelector(".special");
console.log(special);
special.addEventListener("click", (event) => {
    console.log(event);
    const rect = special.getBoundingClientRect();
    console.log(rect);
    console.log(`client: ${event.pageX}, ${event.pageY}`);
    console.log(`client: ${event.clientX}, ${event.clientY}`)
});


const scroll_by = document.querySelector(".scroll_1");
console.log(scroll_by);
const scroll_to = document.querySelector(".scroll_2");
console.log(scroll_to);
const scroll_in = document.querySelector(".scroll_3");
console.log(scroll_in);
scroll_by.addEventListener("click", (event) => {

    //window.scrollBy(0, 100);
    window.scrollBy({ top: 100, left: 0, behavior: "auto" });
});
scroll_to.addEventListener("click", (event) => {
    window.scrollTo(0, 100);
});
scroll_in.addEventListener("click", (event) => {
    special.scrollIntoView();
});