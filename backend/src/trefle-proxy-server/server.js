const express = require('express');
const cors = require('cors'); // Import cors module
const axios = require('axios'); // Import axios module

const app = express();
const port = 3000;

app.use(cors());

// Define a route to proxy the Trefle API request
app.get('/api/plants/search', async (req, res) => {
    try {
        // Get the query parameter from the client's request
        const query = req.query.q;

        // Make a request to the Trefle API with authorization
        const response = await axios.get(`https://trefle.io/api/v1/plants/search?q=${query}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'KXOAktd7pOnXFbv8s1EeseO-6HvYvfJVxqpREfq2aaQ',
            },
        });

        // Send the Trefle API response back to the client
        res.json(response.data);
    } catch (error) {
        // Handle errors
        console.error(error);
        res.status(500).send('Internal Server Error');
    }
});

// Start the server
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});