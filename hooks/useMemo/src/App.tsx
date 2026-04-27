import { useState, useMemo } from 'react'
import './App.css'

function App() {
  const [number, setNumber] = useState(1);
  const [double, setDouble] = useState(1);

  // very slow func
  const slowFunction = (double) => {
    console.log('show function called');

    for (let i=0; i <1000000000; i++){}

    return double * 2;
  }

  // every time the state changes (React calls App() and re-renders)
  // -> executes on every render -> UI blocks even when we *Add number*
  //const getDouble = slowFunction(double);

  // useMemo
  const getDouble = useMemo(() => slowFunction(double), [double])

  return (
    <>
    <div>
      <h1>Add number</h1>
      <h1>{number}</h1>
      <button onClick={() => setNumber(number+1)}>Add number</button>
    </div>
    <div>
      <h1>Double the number</h1>
      <h1>{double}</h1>
      <button onClick={() => setDouble(getDouble)}>Add Double</button>
    </div>
    </>
    
  )
}

export default App
