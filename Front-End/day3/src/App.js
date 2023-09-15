import './App.css';
import './Components/login.js';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Login from './Components/login.js';
import Signup from './Components/Signup';


function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
    <Route path="/" element ={<Login />}></Route>
    <Route path="/register" element ={<Signup />}></Route>
    <Route path="/login" element ={<Login />}></Route>
    
   
    </Routes>
    </BrowserRouter>
    </div>
  );
}
export default App;
