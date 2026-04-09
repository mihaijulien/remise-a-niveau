import { useState } from 'react'

const App = () => {


  // plusieurs propriétés
  // mais en fait, on utilise le même state
  // 1 composant -> 1 state
  const [count, setCount] = useState<number>(0);
  const [title, setTitle] = useState<string>("Compredre useState");

  const [ time, setTime ] = useState(0);

  const handleLaunchClock = () => {
    setInterval( () => {
      setTime((prevTime) => {
        return prevTime + 1;
      })
    }, 1000);
  }

  const handleIncrement = () => {
    setCount(count+1);
    console.log(count);
  }

  const handleChangeTitle = () => {
    setTitle("Hello World")
  }

  return (
    <>
      <h1>{ title }</h1>
      <h2>Count: {count}</h2>
      <button onClick={ handleIncrement }>
        Increment
      </button>

      <button onClick = { handleChangeTitle }>
        Change title
      </button>

      <h2>Clock: { time }</h2>
      <button onClick = { handleLaunchClock }>
        Launch clock
      </button>
    </>
  )
}

export default App

