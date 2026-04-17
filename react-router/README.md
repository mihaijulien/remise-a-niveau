### React Router

```js
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import HomePage from './pages/HomePage.tsx'
import { createBrowserRouter, RouterProvider } from 'react-router'
import ProfilesPage from './pages/ProfilesPage.tsx'

const router = createBrowserRouter([
  {
    path: '/',
    element: <HomePage />,
    errorElement: <div>Error 404 Not Found</div> // optional
  },
  {
    path: '/profiles',
    element: <ProfilesPage />
  },
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
);
```

Link vs a

```js
<Link to="/">Home from Link</Link>
<a href="/">Home from A</a>
```

- **\<Link to="...">** prevents the browser's default behavior (full reload) and lets React Router handle the navigation internally.
- **\<a href="...">**: browser treats it as a traditional navigation → it unloads the current React app completely and loads the page from scratch.

#### Nesting routes

```js
{
  path: '/profiles',
  element: <ProfilesPage />,
  children: [
    {
      path: '/profiles/:profileId',
      element: <ProfilePage />
    }
  ]
}
```

React Router expects the parent component (ProfilesPage) to render an <Outlet /> where the child route component (ProfilePage) should appear.

```js
import { Link, Outlet } from 'react-router-dom';

export default function ProfilesPage() {
    const profiles = [1,2,3,4,5];

    return (
        <div style={{ display: 'flex', gap: '0.5rem' }}>
            <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                {profiles.map((profile) => (
                    <Link key={profile} to={`/profiles/${profile}`}>
                        Profile {profile}
                    </Link>
                ))}
            </div>
            <Outlet /> {/* This renders the ProfilePage */}
        </div>
    );
}
```
