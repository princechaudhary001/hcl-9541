import { useEffect, useState } from 'react'

function UseFetchApi() {
    const [serverData,setServerData]=useState([]);
    useEffect(()=>{

        async function getData(){
            try{
                    const response = await fetch("https://fakestoreapi.com/products");
                    if (!response.ok) {
                        throw new Error(`Request failed with status ${response.status}`);
                    }
                    const jsonData = await response.json();
                    console.log("Data from server is",jsonData);
                    setServerData(jsonData);

            }
            catch(e){
                console.error("Error fetching products:",e);


            }
        }
        getData();

    },[])
    return (
    <div>
        <h2>Products</h2>
        {serverData.map((product) => (
            <p key={product.id}>{product.title}</p>
        ))}
    </div>
    );
}
export default UseFetchApi;