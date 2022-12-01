import { useEffect, useState } from "react";
import OpportunityList from "../components/opportunities/OpportunityList";
import Layout from "../layout/Layout";

function Opportunities() {
  const [isLoading, setLoading] = useState(true);

  const [loadedOpportunities, setLoadedOpportunities] = useState([]);

  useEffect(() => {
    setLoading(true);
    fetch("http://localhost:8090/api/v1/opportunities")
      .then((response) => response.json())
      .then((responseData) => {
        if (responseData) {
          const opportunities = [];

          for (const e in responseData) {
            const opportunities = {
              id: e,
              ...responseData[e],
            };

            opportunities.push(opportunities);
          }

          setLoading(false);
          setLoadedOpportunities(opportunities);
        }
      });
  }, []);

  if (isLoading) {
    return (
      <Layout>
        <h1>Opportunities</h1>
      </Layout>
    );
  }

  return (
    <Layout>
      <section>
          <h1>Opportunities</h1>
        <OpportunityList opportunities={loadedOpportunities} />
      </section>
    </Layout>
  );
}

export default Opportunities;
