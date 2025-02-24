import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/MovieList.css'; 
function MovieList({ onSelectMovie }) {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/movies')
            .then(response => {
                setMovies(response.data);
            });
    }, []);

    return (
        <div>
            <h2>Movies</h2>
            <ul>
                {movies.map(movie => (
                    <li key={movie.id} onClick={() => onSelectMovie(movie)}>
                        {movie.title} ({movie.genre})
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default MovieList;
