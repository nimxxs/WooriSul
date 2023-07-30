document.addEventListener("DOMContentLoaded", function() {
    let slider = document.querySelector(".slider");
    let images = document.querySelectorAll(".slider img");
    let currentIndex = 0;
    let interval;

    function slideNext() {
        currentIndex = (currentIndex + 1) % images.length;
        updateSlider();
    }

    function updateSlider() {
        slider.style.transform = `translateX(-${currentIndex * 1000}px)`;
    }

    function startAutoSlide() {
        interval = setInterval(slideNext, 3000); // 3초마다 다음 이미지로 자동 슬라이드
    }

    function stopAutoSlide() {
        clearInterval(interval);
    }


    // 자동 슬라이드 시작
    startAutoSlide();
});
