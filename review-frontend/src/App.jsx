import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import HomePage from "./pages/HomePage.jsx";
import AddReviewPage from "./pages/AddReviewPage.jsx";

const App = () => {
  return (
    <div>
      <nav className="navbar">
        <h1>Movie Reviews</h1>
        <div>
          <Link to="/" className="nav-link">Home</Link>
          <Link to="/add" className="nav-link">Add Review</Link>
        </div>
      </nav>

      <div className="main-content">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/add" element={<AddReviewPage />} />
        </Routes>
      </div>
    </div>
  );
};

export default App;
