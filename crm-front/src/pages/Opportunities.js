import { useEffect, useState } from "react";
import PlannedActionList from "../components/planned_actions/PlannedActionList";
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
        <span>...</span>
      </Layout>
    );
  }

  return (
    <Layout>
      <section>
          <h1>Opportunities</h1>
          <div style={{ display: "flex", justifyContent: "left" }}>
            <div className="field" style={{margin: "10px"}}>
              <input type="button" name="list" value="List" />
            </div>
            <div className="field" style={{margin: "10px"}}>
              <input type="button" name="list" value="Tree" />
            </div>
            <div className="field" style={{margin: "10px"}}>
              <input type="button" name="list" value="Kanban" />
            </div>
          </div>
        <OpportunitiyList opportunities={loadedOpportunities} />
      </section>
    </Layout>
  );
}

export default Opportunities;
