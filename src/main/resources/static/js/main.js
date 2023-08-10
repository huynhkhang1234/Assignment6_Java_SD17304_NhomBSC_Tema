

/* ====================== Dropdown Menu ====================== */
// const dropdownMenu = document.querySelector(".my-dropdown-menu");
// const toggleNavbar = document.querySelector(".toggle-navbar");
// const dropdownClose = document.querySelector(".dropdown-close");
// const navMenu = document.querySelector(".nav-menu");

// dropdownMenu.addEventListener("click", function () {
//     if (window.innerWidth < 576) {
//         dropdownMenu.classList.add('show');
//         toggleNavbar.classList.add('hide');
//     }
// });

// dropdownClose.addEventListener('click', function () {
//     if (window.innerWidth < 576) {
//         dropdownMenu.classList.remove('show');
//         toggleNavbar.classList.remove('hide');
//     }
// });

// toggleNavbar.addEventListener('click', function () {
//     if (window.innerWidth < 576) {
//         navMenu.classList.toggle('show');
//         if (navMenu.classList.contains('show')) {
//             this.classList.replace('bi-list', 'bi-x');
//         } else {
//             this.classList.replace('bi-x', 'bi-list');
//         }
//     }
// });

/* Button Back To Top Javascript */
const backToTopBtn = document.querySelector('#btn-back-top');

window.addEventListener('scroll', function () {
    if (window.pageYOffset > 300) {
        if (!backToTopBtn.classList.contains('btnEntrance')) {
            backToTopBtn.classList.add('btnEntrance');
            backToTopBtn.classList.remove('btnExit');
            backToTopBtn.style.display = 'block';
        }
    }
    else {
        if (backToTopBtn.classList.contains('btnEntrance')) {
            backToTopBtn.classList.add('btnExit');
            backToTopBtn.classList.remove('btnEntrance');
            setTimeout(function () {
                backToTopBtn.style.display = 'none';
            }, 250);
        }
    }
});


backToTopBtn.addEventListener('click', function () {
    window.scrollTo(0, 0);
});


// /* Mobile Navbar Toggle */
// const navbar = document.querySelector('[data-navbar]');
// const navToggle = document.querySelector('[data-nav-toggler]');

// navToggle.addEventListener("click", function () {
//     navbar.classList.toggle('active');
//     this.classList.toggle('active');
// });

/* Button Search */
const search = document.querySelector('.search-box');
const searchBtn = document.querySelector('#search-icon');
searchBtn.addEventListener('click', function () {
    search.classList.toggle('active');
});


