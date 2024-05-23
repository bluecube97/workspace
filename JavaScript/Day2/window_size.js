'use strict';

const tag = document.querySelector('.tag');
console.log(tag);

window.addEventListener('resize', () =>{
   tag.innerHTML = `
   window.screen: ${window.screen.width}, ${window.screen.height}
    window.outer: ${window.outerWidth}, ${window.outerHeight}
    window.inner: ${window.innerWidth}, ${window.innerHeight}
    window.client: 
   `;
});