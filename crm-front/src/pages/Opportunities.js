import { useEffect, useState } from "react";
import OpportunityList from "../components/opportunities/OpportunityList";
import Layout from "../layout/Layout";
import classes from "./Opportunities.module.css";

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
            const opportunity = {
              id: e,
              ...responseData[e],
            };

            opportunities.push(opportunity);
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
          <h1 className={classes}>Opportunities</h1>
        <OpportunityList opportunities={loadedOpportunities} />
    </Layout>
  );
}

export default Opportunities;
