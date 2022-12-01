import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './pages/Login';
import PlannedActions from './pages/PlannedActions';

function App() {

  const isAuthenticated = localStorage.getItem("accessToken") === "X5#$Y3hRzkH1";

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>}/>
        {isAuthenticated ? (
          <Route path='/plannedActions' element={<PlannedActions/>}/>
        ) : (
          <Route path='/plannedActions' element={<Login/>}/>
        )}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
