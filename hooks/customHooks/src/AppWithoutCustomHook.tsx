import { useState } from 'react'
import './App.css'

function AppWithoutCustomHook() {
  const [isVisible, setIsVisible] = useState(false);

  return (
    <div className="App">
      <button onClick={() => setIsVisible((prev) => !prev)}>
        {isVisible ? "Hide" : "Show"}
      </button>
      {isVisible && <h1>Hidden Text</h1>}
    </div>
  )
}

export default AppWithoutCustomHook
