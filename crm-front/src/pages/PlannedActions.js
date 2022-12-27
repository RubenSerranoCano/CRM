import { useEffect, useState } from "react";
import PlannedActionList from "../components/planned_actions/PlannedActionList";
import Layout from "../layout/Layout";

function PlannedActions() {
  const [isLoading, setLoading] = useState(true);

  const [loadedPlannedActions, setLoadedPlannedActions] = useState([]);

  useEffect(() => {
    setLoading(true);
    console.log(localStorage.getItem("accessToken"))
    const requestOptions = {
      headers: {"Content-Type": "application/json", "Authorization": "Bearer " + localStorage.getItem("accessToken")},
    };
    fetch("http://localhost:8090/api/v1/plannedActions", requestOptions)
      .then((response) => response.json())
      .then((responseData) => {
        if (responseData) {
          const plannedActions = [];

          for (const e in responseData) {
            const plannedAction = {
              id: e,
              ...responseData[e],
            };

            plannedActions.push(plannedAction);
          }

          setLoading(false);
          setLoadedPlannedActions(plannedActions);
        }
      });
  }, []);

  if (isLoading) {
    return (
      <Layout>
        <h1>Planned actions</h1>
      </Layout>
    );
  }

  return (
    <Layout>
      <h1 name="plannedActions-header">Planned actions</h1>
      <div style={{ display: "flex", justifyContent: "left" }}>
        <div className="field" style={{ margin: "10px" }}>
          <input type="button" name="list" value="List" />
        </div>
        <div className="field" style={{ margin: "10px" }}>
          <input type="button" name="list" value="Tree" />
        </div>
        <div className="field" style={{ margin: "10px" }}>
          <input type="button" name="list" value="Kanban" />
        </div>
      </div>
      <PlannedActionList plannedActions={loadedPlannedActions} />
    </Layout>
  );
}

export default PlannedActions;
