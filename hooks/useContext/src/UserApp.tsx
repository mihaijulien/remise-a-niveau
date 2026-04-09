import { useState, createContext, useContext } from 'react';

const UserContext = createContext("John Doe");

// composant principal UserApp
export const UserApp = () => {
    const [user, setUser] = useState("John Doe");
    const [counter, setCounter] = useState(0);

    return (
        <UserContext.Provider value = {{
            updateUser: (newUser) => setUser(newUser),
            user
        }}>
            <button onClick={() => setCounter(c => c + 1)}>
                Counter: {counter}
            </button>
            <UserForm />
            <UserName />
        </UserContext.Provider>
    );
};

// composant UserForm
const UserForm = () => {
    const { updateUser } = useContext(UserContext);
    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const user = formData.get("user"); 
        updateUser(user);
        
        e.target.reset();
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="user" />
            <button type="submit">Submit</button>
        </form>
    );
};

// composant UserName
const UserName = () => {
    const { user } = useContext(UserContext);
    return <div>Name: {user}</div>;
};