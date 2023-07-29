const chart = document.querySelector("#chart").getContext('2d');

new Chart(chart, {
    type: 'line',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov'],
        datasets: [
            {
                label: 'BTC',
                data: [29374, 33537, 49631, 59095,
                    57828, 36684, 33572, 39974, 48847,
                    48116, 61004],
                borderColor: 'red',
                borderWidth: 2

            },
            {
                label: 'ETH',
                data: [31500, 41000, 88800, 26000, 46000,
                    32698, 5000, 3000, 18656, 24832, 36844],
                borderColor: 'blue',
                borderWidth: 2
            }
        ]
    },
    options:{
        responsive: true

    }

});

/* ==================== Dark & Light Mode ==================== */
const toggle = document.querySelector('.theme-btn');
const switchBtn = document.querySelector('.switch');
const imgBtn = document.querySelector('.bi-icon');

toggle.addEventListener('click', function () {
    switchBtn.classList.toggle('active');
    if (switchBtn.classList.contains('active')) {
        imgBtn.classList.replace('bi-brightness-high', 'bi-moon-stars');
    } else {
        imgBtn.classList.replace('bi-moon-stars', 'bi-brightness-high');
    }
    document.body.classList.toggle('dark');
})

/* ==================== Sidebar Tabs ==================== */
const sidebars = document.querySelectorAll('.sidebar');

sidebars.forEach((sidebar) => {
    sidebar.addEventListener('click', function () {
        sidebars.forEach((tab) => {
            tab.firstElementChild.classList.remove('active');
        });

        sidebar.firstElementChild.classList.add('active');
    });

});
