import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import FocusInput from './components/FocusInput'


createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <FocusInput />
  </StrictMode>,
)
