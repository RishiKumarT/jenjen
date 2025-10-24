import React, { useEffect, useState } from "react";
import axios from "axios";

const HomePage = () => {
  const [reviews, setReviews] = useState([]);
  const baseUrl = import.meta.env.VITE_API_BASE_URL;

  useEffect(() => {
    axios
      .get(`${baseUrl}/all`)
      .then((res) => setReviews(res.data))
      .catch(() => console.error("Failed to fetch reviews"));
  }, []);

  return (
    <div className="home-container">
      <h2>Movie Reviews</h2>
      {reviews.length === 0 ? (
        <p>No reviews available.</p>
      ) : (
        <div className="reviews-list">
          {reviews.map((r) => (
            <div key={r.id} className="review-card">
              <h3>{r.movie}</h3>
              <p><strong>User:</strong> {r.user}</p>
              <p><strong>Rating:</strong> ⭐ {r.rating}/10</p>
              <p><em>{r.comment}</em></p>
              <p className="review-date">{r.date}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default HomePage;
