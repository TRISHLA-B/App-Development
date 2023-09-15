import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import "./login.css";

function Login() {
  const nav = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setpassword] = useState('');
  const [user, setUser] = useState([]);

  const authenticate = (e) => {
    e.preventDefault();
    const usercheck = user.find(user => (user.username === username && user.password === password));

    if (username.length === 0) {
      alert("Enter Username");
    } else if (password.length === 0) {
      alert("Enter Password");
    } 
    
     else {
      alert("Successfully Loggedin!");
    }
  }

  return (
    <div id="body">
      <div className="signup-form">
        <div className="container">
          <div className="header">
            <h1>VTN SOLUTIONS</h1>
            <p>Enter Employee Details</p>
          </div>

          <form>
            <div className="input">
              <i className="fa-solid fa-user"></i>
              <input type="text" onChange={(e) => setUsername(e.target.value)} placeholder="Username" />
            </div>
            <div className="input">
              <i className="fa-solid fa-lock"></i>
              <input type="password" onChange={(e) => setpassword(e.target.value)} placeholder="Password" />
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
