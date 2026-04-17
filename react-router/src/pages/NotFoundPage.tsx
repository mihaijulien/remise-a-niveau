import { Link } from 'react-router-dom';
 
export default function NotFoundPage() {
    return (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
            404 Not Found Page

            <Link to="/">Home from Link</Link>
            <a href="/">Home from A</a>
        </div>
    );
}