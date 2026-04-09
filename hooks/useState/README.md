## useState

Dans l'example suivant, la valeur de la variable count est mise à jour mais l'interface ne change pas:

```ts
function App() {

  let count = 0;

  const handleIncrement = () => {
    count++;
    console.log(count);
  }

  return (
    <>
      <h1>Comprendre useState</h1>
      <h2>Count: {count}</h2>
      <button onClick={ handleIncrement }>
        Increment
      </button>
    </>
  )
}

export default App
```

Il faut utiliser `useState` pour que React mette l’interface à jour au bon moment.

L’**état**, c’est l’ensemble des paramètres qui vont permettre de définir la façon dont le composant va être affiché à un instant T.