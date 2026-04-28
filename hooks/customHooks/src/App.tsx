import './App.css';
import { useToggle } from './useToggle';

function App() {
  
  const [isVisible, setIsVivible] = useToggle();

  return (
    <div className="App">
      <button onClick={setIsVivible}>
        {isVisible ? "Hide" : "Show"}
      </button>
      {isVisible && <h1>Hidden Text</h1>}
    </div>
  )
}

export default App
