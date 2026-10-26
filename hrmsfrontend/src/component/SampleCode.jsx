import { useEffect, useState } from 'react'

function SampleCode() {
    const [counter,setCounter]=useState(20);
    const [pointer,setPointer]=useState(100);

    useEffect(()=>{
        console.log("Component is render");
        console.log("Counter value is",counter);
    },[pointer,counter])

    function changeCounter(){
        setCounter(counter+2);
    }
    function changePointer(){
        setPointer(pointer-2);
    }
  return (
    <div>
        {/* <h2>Employee Details</h2>
        <div style={{border:"1px solid white",width:"300px",margin:"10px"}}>
            <h3>Name:{empdata.ename}</h3>
            <h3>empid:{empdata.empid}</h3>
        </div> */}
        <h2>Counter value={counter}</h2>
         <h2>Pointer value={pointer}</h2>
        <button onClick={changeCounter}>Counter</button>
        <button onClick={changePointer}>Pointer</button>
    </div>
  )
}

export default SampleCode