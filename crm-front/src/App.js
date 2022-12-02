import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Login from "./pages/Login";
import Opportunities from "./pages/Opportunities";
import PlannedActions from "./pages/PlannedActions";

function App() {
  const isAuthenticated =
    localStorage.getItem("accessToken") === "X5#$Y3hRzkH1";

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        {isAuthenticated ? (
          <React.Fragment>
            <Route path="/plannedActions" element={<PlannedActions />} />
            <Route path="/opportunities" element={<Opportunities />} />
          </React.Fragment>
        ) : (
          <React.Fragment>
            <Route path="/plannedActions" element={<Login />} />
            <Route path="/opportunities" element={<Login />} />
          </React.Fragment>
        )}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
