let slideIndex = 0;
const slides = document.querySelector('.slides');
const totalSlides = document.querySelectorAll('.slide').length;
let autoSlideInterval;

// Функция для отображения текущего слайда
function showSlides() {
    slides.style.transform = `translateX(${-slideIndex * 100}%)`;
}

// Функция для перелистывания слайдов
function plusSlides(n) {
    slideIndex = (slideIndex + n + totalSlides) % totalSlides;
    showSlides();
    resetAutoSlide(); // Сброс интервала при ручном перелистывании
}

// Функция для автоматического перелистывания
function autoSlide() {
    slideIndex = (slideIndex + 1) % totalSlides;
    showSlides();
}

// Функция для сброса интервала автоматического перелистывания
function resetAutoSlide() {
    clearInterval(autoSlideInterval);
    autoSlideInterval = setInterval(autoSlide, 3000); // Перезапуск интервала
}

// Инициализация автоматического перелистывания
autoSlideInterval = setInterval(autoSlide, 3000);

// Обработчики событий для кнопок "Назад" и "Вперед"
document.querySelector('.prev').addEventListener('click', () => plusSlides(-1));
document.querySelector('.next').addEventListener('click', () => plusSlides(1));

// Показываем первый слайд при загрузке страницы
showSlides();