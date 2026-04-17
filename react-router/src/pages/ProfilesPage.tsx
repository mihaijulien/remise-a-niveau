import { NavLink, Outlet } from 'react-router-dom';

export default function ProfilesPage() {
    const profiles = [1,2,3,4,5];

    return (
        <div style={{ display: 'flex', gap: '0.5rem' }}>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                {profiles.map((profile) => (
                    <NavLink key={profile} to={`/profiles/${profile}`}
                    className={({isActive}) => {
                        return isActive ? 'text-primary-700' : '';
                    }}>
                        Profile {profile}
                    </NavLink>
                ))}
            </div>
            <Outlet />
        </div>
    );
}