const title = document.querySelector("header h1");
const text = title.textContent;
title.textContent = "";
let i = 0;

function type() {
  if (i < text.length) {
    title.textContent += text.charAt(i);
    i++;
    setTimeout(type, 150);
  } else {
    setTimeout(() => {
      title.textContent = "";
      i = 0;
      type();
    }, 15000); 
  }
}

window.addEventListener('load', type);

// script.js
const elements = document.querySelectorAll('.project-experience li, .aboutme');

const revealOnScroll = () => {
  elements.forEach(el => {
    const rect = el.getBoundingClientRect();
    if (rect.top < window.innerHeight - 100 && rect.bottom > 0) {
      el.classList.add('visible');
    } else {
      el.classList.remove('visible');
    }
  });
};

window.addEventListener('scroll', revealOnScroll);
window.addEventListener('load', revealOnScroll);
