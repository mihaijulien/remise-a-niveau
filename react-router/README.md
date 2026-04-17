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