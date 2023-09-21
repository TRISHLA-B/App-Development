import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux'; 
import { login, setUserName } from './authSlice'; 
import './login.css';

function Login() {
  const nav = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState(''); 

  const dispatch = useDispatch(); 

  const authenticate = (e) => {
    e.preventDefault();
    
    if (username.length === 0) {
      alert('Enter Username');
    } else if (password.length === 0) {
      alert('Enter Password');
    } else {
      const user = { username: username, name: username }; // Set the name to the entered username
      
      // Dispatch login action to set isAuthenticated to true and set the user
      dispatch(login(user));
      
      
      dispatch(setUserName(username)); 
      
      nav('/home');
    }
  }
  
  return (
    <div id="body">
      <div className="signup-form">
        <div className="container">
          <div className="header">
            <h1>VTN SOLUTIONS</h1>
            
          </div>

          <form>
            <div className="input">
              <i className="fa-solid fa-user"></i>
              <input type="text" onChange={(e) => setUsername(e.target.value)} placeholder="Username" />
            </div>
            <div className="input">
              <i className="fa-solid fa-lock"></i>
              <input type="password" onChange={(e) => setPassword(e.target.value)} placeholder="Password" />
            </div>
            <input onClick={authenticate} className="signup-btn" type="submit" value="LOGIN" />
          </form>
          <Link to="/register"><p>New Account Signup Now!</p></Link>
        </div>
      </div>
    </div>
  )
}

export default Login;


