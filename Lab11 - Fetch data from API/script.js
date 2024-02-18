async function generateChart() {
    // Write your code here. You can write your own function(s) if you want.

    // Reset the old chart
    if (window.chart) {
        window.chart.destroy();
    }

    // Fetch API
    const response = await fetch("https://restcountries.com/v3.1/all");
    let responseData = await response.json();

    var ul = document.getElementById("numberOfCountries");
    const numberOfCountries = parseInt(ul.value);
    responseData = responseData.slice(0, numberOfCountries);

    console.log(responseData);  // Log the fetched data

    const ctx = document.getElementById('barChart');

    
    window.chart = new Chart(ctx, {
        type: 'bar',
        data: {
        labels: responseData.map(country => country.name.common), 
        datasets: [{
            label: 'Total Population',
            data: responseData.map(country => country.population),
            borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    })
};