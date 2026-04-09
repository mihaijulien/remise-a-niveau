import { useState } from 'react';

// composant principal UserApp
export const UserApp = () => {
    const [user, setUser] = useState<string>("John Doe");
    const [counter, setCounter] = useState<number>(0);

    return (
        <div>
            <button onClick={() => setCounter(c => c + 1)}>
                Counter: {counter}
            </button>
            <UserForm updateUser={(newUser: string) => setUser(newUser)} />
            <UserName user={user} />
        </div>
    );
};

// props pour UserForm
interface UserFormProps {
    updateUser: (newUser: string) => void;
}

// composant UserForm
const UserForm = ({ updateUser }: UserFormProps) => {
    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const user = formData.get("user"); 
        if (typeof user === "string") {
            updateUser(user);
        }  
        e.target.reset();
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="user" />
            <button type="submit">Submit</button>
        </form>
    );
};

// props pour UserName
interface UserNameProps {
    user: string;
}

// composant UserName
const UserName = ({ user }: UserNameProps) => {
    return <div>Name: {user}</div>;
};