import { useRef } from 'react';

function FocusInput() {
  const inputRef = useRef(null);

  const handleFocus = () => {
    inputRef.current?.focus();
  };

  return (
    <div>
      <input
        ref={inputRef}
        type="text"
        placeholder="Click the button to focus"
      />
      <button onClick={handleFocus}>
        Focus the Input
      </button>
    </div>
  );
}

export default FocusInput;