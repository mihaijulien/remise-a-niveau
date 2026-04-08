import Article from "./composants/Article"
import { useState, useEffect } from 'react';

interface ArticleData {
    userId: number;
    id: number;
    title: string;
    body: string;
}

function App() {

      const [ article, setArticle ] = useState<ArticleData | null>(null);
  
      useEffect( () => {
          fetch('https://jsonplaceholder.typicode.com/posts/1')
          .then(res => res.json())
          .then((data: ArticleData) => setArticle(data))
          .catch(err => console.error(err));
      }, []);

  return (
    <>
    <h1>Comprendre useEffect</h1>
    {/* lors du premier rendu, article est null. 
        donc article.title et article.body vont provoquer une erreur.
        on doit vérifier donc que l'article existe tout d'abord. */}
    {article &&
     <Article title = {article.title}>
        { article.body } 
     </Article> 
    }
    </>
  )
}

export default App
