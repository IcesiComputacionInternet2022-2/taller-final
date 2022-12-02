import axios from 'axios';

export class PostMethod {
    static post(newItem, serviceRoute) {


        const url = 'http://localhost:8080/' + serviceRoute;
        const config = this.getHeaderConfig();
    
    
        return axios.post(url, newItem, config)
            .then(res => res.data)
            .catch(function(error) {
                if (error.response) {
                    alert("ERROR " + error.response.data.code + "\n" + error.response.data.message);
    
                } else if (error.request) {
                    console.log(error.request);
                } else {
                    console.log('Error', error.message);
                }
    
            });
    
    }

    static getHeaderConfig(){

        const webToken = localStorage.getItem("webToken")?localStorage.getItem("webToken"):'';

        const config = {
            headers: { Authorization: 'Bearer '+ webToken}
        };

        return config;

    }
}
