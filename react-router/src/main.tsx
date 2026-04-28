import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import HomePage from './pages/HomePage.tsx'
import { createBrowserRouter, RouterProvider,  Routes, Route } from 'react-router-dom'
import ProfilesPage from './pages/ProfilesPage.tsx'
import NotFoundPage from './pages/NotFoundPage.tsx'
import ProfilePage from './pages/ProfilePage.tsx'
import { App } from './pages/App.tsx'

const router = createBrowserRouter([
  {
    path: '/',
    element: <HomePage />,
    errorElement: <NotFoundPage />,
  },
  {
    path: '/profiles',
    Component: ProfilesPage,
    children: [
      {
        path: '/profiles/:profileId',
        element: <ProfilePage />
      }
    ]
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/* Data mode */}
    <RouterProvider router={router} />

    {/* Declarative mode */}
    <Routes>
      <Route path="/" element={<App/>} />
      <Route path="*" element={<h1>Error page</h1>} />
    </Routes>
    
  </StrictMode>,
);
