import { Link } from 'react-router-dom';

export default function ProfilesPage() {
    const profiles = [1,2,3,4,5];

    return (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
            {profiles.map((profile) => (
                <Link key={profile} to={`/profiles/${profile}`}>
                    Profile {profile}
                </Link>
            ))}
        </div>
    );
}