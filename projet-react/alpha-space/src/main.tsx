import { createRoot } from 'react-dom/client'
import './index.css'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import { HomeLayout } from './pages'

const router = createBrowserRouter([{path: "/", element: <HomeLayout />}]);

createRoot(document.getElementById('root')!).render(
  <RouterProvider router={router} />
);
