import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import validator from 'validator';
import "./Signup.css";

function Signup() {
  const nav = useNavigate();
  const [name, setname] = useState('');
  const [age, setAge] = useState('');
  const [email, setemail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setpassword] = useState('');
  const [conpassword, setconpassword] = useState('');
  const [error, setError] = useState('');

  const senddb = (e) => {
    e.preventDefault();
    setError(''); 

    if (age.length === 0 || email.length === 0 || password.length === 0 || name.length === 0 || username.length === 0) {
      alert('Enter all fields');
      return;
    }
    
    if (!validator.isEmail(email)) {
      alert('Enter a valid Email');
      return;
    }

    if (password !== conpassword) {
      alert('Password and Confirm Password must be the same');
      return;
    }

    
    nav('/login');
  };

  return (
    <div id="body">
      <div className='signup-form'>
        <div className='container'>
          <div className='header'>
            <h1>Create an Account</h1>
            <p></p>
          </div>
          <form>
            <div className="input">
              <i className="fa-solid fa-user"></i>
              <input type="text" value={name} onChange={(e) => setname(e.target.value)} placeholder="Name" />
            </div>
            <div className="input">
              <i className="fa-solid fa-user"></i>
              <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Id" />
            </div>
            <div className="input">
              <i className="fa-solid fa-envelope"></i>
              <input type="email" value={email} onChange={(e) => setemail(e.target.value)} placeholder="Email" />
            </div>
            <div className="input">
              <i className="fa-solid fa-envelope"></i>
              <input type="number" value={age} onChange={(e) => setAge(e.target.value)} placeholder="Age" />
            </div>
            <div className="input">
              <i className="fa-solid fa-lock"></i>
              <input type="password" value={password} onChange={(e) => setpassword(e.target.value)} placeholder="Password" />
            </div>
            <div className="input">
              <i className="fa-solid fa-lock"></i>
              <input type="password" onChange={(e) => setconpassword(e.target.value)} placeholder="Confirm Password" />
            </div>
            {error && <p className="text-danger">{error}</p>}
            <input className="signup-btn" onClick={senddb} type="submit" value="SIGN UP" />
          </form>
          <Link to="/">  <p>Existing Employee? Sign in</p></Link>
          
        </div>
      </div>
    </div>
  );
}

export default Signup;
