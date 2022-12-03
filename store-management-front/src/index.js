import React from 'react';
import ReactDOM from 'react-dom/client';
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import './index.css';
import App from './App';
import Navbar from './components/Navbar';
import Register from './components/Register';
import List from './components/List';
import Cart from './components/Cart';
import AdminDashboard from './components/AdminDashboard';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Navbar />
    <Router>
      <Routes>
        <Route exact path='/' element={<App/>} />
        <Route path='register' element={<Register/>} />
        <Route path='list' element={<List/>} />
        <Route path='cart' element={<Cart/>} />
        <Route path='admin/*' element={<AdminDashboard/>} />
      </Routes>
    </Router>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
