import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

export const getAccesos = async () => {
  return axios.get(`${API_BASE_URL}/accesos`);
};
