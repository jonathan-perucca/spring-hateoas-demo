const axios = require('axios').default;

export default {
    getAll() {
        return axios.get('http://localhost:8080/articles')
            .then(({data}) => data)
            .catch(error => console.error(error))
    }
}