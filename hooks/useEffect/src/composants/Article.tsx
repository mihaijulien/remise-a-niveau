import { useState, useEffect, type ReactNode } from 'react';


const convertSecondsToMMS = (timeInSeconds: number | string): string => {
    timeInSeconds = Number(timeInSeconds);
    const h = Math.floor(timeInSeconds / 3600);
    const m = Math.floor(timeInSeconds % 3600 / 60);
    const s = Math.floor(timeInSeconds % 3600 % 60);

    const hDisplay = h < 10 ? '0' + h : h;
    const mDisplay = m < 10 ? '0' + m : m;
    const sDisplay = s < 10 ? '0' + s : s;

    return `${hDisplay}:${mDisplay}:${sDisplay}`;
};

interface ArticleProps {
    title?: string;
    children?: ReactNode;
}

const Article = ( {title = ' ', children = null}: ArticleProps) => {
    const [ elapsedTime, setElapsedTime ] = useState<number>(0);

    useEffect( () => {
        // useEffect s'exécute TOUJOURS au montage du composant
        // mais s'exécute AUSSI a chaque mise à jour du STATE
        console.log("Article is mounted");
        const intervalId = setInterval( () => {
            setElapsedTime(prevTime => prevTime + 1)
        }, 1000);

        return () => {
            // cette partie s'exécute à la destruction du composant
            clearInterval(intervalId);
        }
    }, []); // [] -> le tableau de dépendances
    // si le tableau est vide, useEffect s'exécute SEULEMENT au montage du composant
    // => il ignore les mise à jour du STATE

    return ( 
        <div>
            <h2>{ title }</h2>
            <p>Temps de lecture: { convertSecondsToMMS(elapsedTime) }</p>
            { children }
        </div>
    )
}

export default Article;